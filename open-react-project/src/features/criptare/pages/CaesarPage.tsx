import { Col, Row, Table, Textarea } from "ebs-design";
import {useDebounce, useStateHandlers} from "hooks";

interface StateProps {

}

export const CaesarPage = () => {
  const [state, setState] = useStateHandlers<StateProps>({});

  useDebounce(() => {
    console.log('in debounce')
  }, 3000);

  return (
    <Row className="caesar-page">
      <Col className="flex flex--column">
        <Row>
          <Col className="flex justify-content--center">
            <h3>Sistemul de criptare caesar</h3>
          </Col>
        </Row>
        <Row className="mt-30">
          <Col className="flex justify-content--center">
            Introduceti textul ce doriti sa fie decriptat
          </Col>
        </Row>
        <Row className="justify-content--center">
          <Col className="flex justify-content--center">
            <Textarea
              placeholder="Text field"
              className="caesar-page__textarea"
            />
          </Col>
        </Row>
        <Row>
          <Col className="flex justify-content--center"><Table  /></Col>
        </Row>
      </Col>
    </Row>
  );
};
