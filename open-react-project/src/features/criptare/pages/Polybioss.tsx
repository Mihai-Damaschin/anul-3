import { Button, Col, Row, Textarea } from "ebs-design";
import { useStateHandlers } from "hooks";
import { useEffect, useRef } from "react";

interface StateProps {
  encryptionTextarea: string;
  encryptedText: string;
  decryptionTextarea: string;
  decryptionText: string;
}

const KEY = "ABCDE";
const alphabet = String.fromCharCode(
  ...Array.from({ length: 26 }, (_, key) => 65 + key)
);

export const PolybiossPage = () => {
  const [state, setState] = useStateHandlers<StateProps>({
    encryptionTextarea: "",
    encryptedText: "",
    decryptionText: "",
    decryptionTextarea: "",
  });

  const table = useRef<{ [key: string]: string }>({});

  useEffect(() => {
    const $key = KEY.split("");

    let i = 0;

    $key.forEach((column, columnKey) =>
      $key.forEach(
        (row, rowKey) =>
          (table.current = {
            ...table.current,
            [alphabet[i++]]: `${alphabet[columnKey]}${alphabet[rowKey]}`,
          })
      )
    );
  }, []);

  const onDecryptClick = () => {
    setState((prevState) => ({
      decryptionText: prevState.decryptionTextarea
        .split(" ")
        .map((encryptedWord) => {
          let counter = 0;

          return Array.from({ length: encryptedWord.length / 2 }, () => {
            const encryptedSymbol = encryptedWord.slice(counter, counter + 2);

            counter += 2;

            return Object.keys(table.current).find(
              (i) => table.current[i] === encryptedSymbol
            );
          }).join("");
        })
        .join(" "),
    }));
  };

  const onEncryptClick = () =>
    setState((prevState) => ({
      encryptedText: prevState.encryptionTextarea
        .toUpperCase()
        .split("")
        .map((i) => table.current[i] || " ")
        .join(""),
    }));

  const onEncryptTextAreaChange = (value: string) =>
    setState({ encryptionTextarea: value });
  const onDecryptTextareaChange = (value: string) =>
    setState({ decryptionTextarea: value });

  return (
    <>
      <Row>
        <Col className="flex justify-content--center">
          <h3>Sistemul de criptare Polybios</h3>
        </Col>
      </Row>
      <Row className="caesar-page">
        <Col className="flex flex--column">
          <Row className="mt-30">
            <Col className="flex justify-content--center">
              Introduceti textul ce doriti sa fie criptat
            </Col>
          </Row>

          <Row className="justify-content--center mb-30">
            <Col className="flex justify-content--center">
              <Textarea
                placeholder="Text field"
                className="caesar-page__textarea"
                onChange={onEncryptTextAreaChange}
                value={state.encryptionTextarea}
              />
            </Col>
          </Row>

          <Row className="justify-content--center mb-30">
            <Col className="flex justify-content--center">
              <Button onClick={onEncryptClick}>Cripteaza</Button>
            </Col>
          </Row>

          <Row>
            <Col className="flex justify-content--center">
              {state.encryptedText}
            </Col>
          </Row>
        </Col>
        <Col className="flex flex--column">
          <Row className="mt-30">
            <Col className="flex justify-content--center">
              Introduceti textul ce doriti sa fie decriptat
            </Col>
          </Row>

          <Row className="justify-content--center mb-30">
            <Col className="flex justify-content--center">
              <Textarea
                placeholder="Text field"
                className="caesar-page__textarea"
                onChange={onDecryptTextareaChange}
                value={state.decryptionTextarea}
              />
            </Col>
          </Row>

          <Row className="justify-content--center mb-30">
            <Col className="flex justify-content--center">
              <Button onClick={onDecryptClick}>Decripteaza</Button>
            </Col>
          </Row>

          <Row>
            <Col className="flex justify-content--center">
              {state.decryptionText}
            </Col>
          </Row>
        </Col>
      </Row>
    </>
  );
};
