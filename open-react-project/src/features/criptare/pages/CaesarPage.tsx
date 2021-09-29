import { Col, Row, Textarea } from "ebs-design";

export const CaesarPage = () => {
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
          <Col className="flex justify-content--center">table</Col>
        </Row>
      </Col>
    </Row>
  );
};
