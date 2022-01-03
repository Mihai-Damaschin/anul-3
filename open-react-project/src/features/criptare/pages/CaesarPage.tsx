import { Button, Col, Row, Table, Textarea } from "ebs-design";
import { useStateHandlers } from "hooks";
import { useMemo } from "react";
import { ColumnType } from "ebs-design/dist/components/organisms/Table/Table";

interface StateProps {
  textarea: string;
  data: TableRow[];
}

interface TableRow {
  key: string;
  decrypted: string;
}

const alphabet = String.fromCharCode(
  ...Array.from({ length: 26 }, (_, key) => 65 + key)
);

export const CaesarPage = () => {
  const [state, setState] = useStateHandlers<StateProps>({
    textarea: "",
    data: [],
  });

  const columns: ColumnType<TableRow>[] = useMemo(
    () => [
      {
        title: "Key",
        dataIndex: "key",
      },
      {
        title: "Decrypted text",
        dataIndex: "decrypted",
      },
    ],
    []
  );

  const onDecryptClick = () => {
    const alphabetGroups = Array.from({ length: 23 }, (_, key) =>
      alphabet.slice(key, 4 + key)
    );

    const possibleKeys = alphabetGroups.flatMap((i) =>
      getPermutations(i.split(""))
    );

    setState({
      data: possibleKeys.map((i) => ({ key: i, decrypted: decryptWithKey(i) })),
    });
  };

  const decryptWithKey = (key: string) => {
    let localAlphabet = alphabet;
    const keyElements = key.split("");

    keyElements.forEach(
      (_, key) => (localAlphabet = localAlphabet.replace(keyElements[key], ""))
    );

    localAlphabet = `${key}${localAlphabet}`;

    return state.textarea
      .toUpperCase()
      .split("")
      .map((i, key) => alphabet[localAlphabet.indexOf(i)])
      .join("");
  };

  const onTextAreaChange = (value: string) => setState({ textarea: value });

  return (
    <Row className="caesar-page">
      <Col className="flex flex--column">
        <Row>
          <Col className="flex justify-content--center">
            <h3>Sistemul de criptare Caesar</h3>
          </Col>
        </Row>
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
              onChange={onTextAreaChange}
              value={state.textarea}
            />
          </Col>
        </Row>

        <Row className="justify-content--center mb-30">
          <Col className="flex justify-content--center">
            <Button onClick={onDecryptClick}>Decripteaza</Button>
          </Col>
        </Row>

        {state.data.length > 0 && (
          <Row>
            <Col className="flex justify-content--center">
              <Table columns={columns} data={state.data} />
            </Col>
          </Row>
        )}
      </Col>
    </Row>
  );
};

const getPermutations = (array: string[]) => {
  let result: string[] = [];

  const permutation = (arr: string[], currentSize: number) => {
    if (currentSize == 1) {
      result.push(arr.join(""));
      return;
    }

    for (let i = 0; i < currentSize; i++) {
      permutation(arr, currentSize - 1);

      if (currentSize % 2 == 1) {
        let temp = arr[0];
        arr[0] = arr[currentSize - 1];
        arr[currentSize - 1] = temp;
      } else {
        let temp = arr[i];
        arr[i] = arr[currentSize - 1];
        arr[currentSize - 1] = temp;
      }
    }
  };

  permutation(array, array.length);

  return result;
};
