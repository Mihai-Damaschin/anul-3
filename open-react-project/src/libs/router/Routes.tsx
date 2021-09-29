import { useCallback } from "react";
import { Route, Switch, useLocation } from "react-router-dom";
import { clearRoutes } from "./routerHelpers";

export const Routes = () => {
  const location = useLocation();

  const notFoundPage = useCallback(
    () => (
      <section className="m-not-found-page">
        <h1 className="color-fff">This page does not exist</h1>
      </section>
    ),
    []
  );

  return (
    <Switch>
      {clearRoutes.map(({ name, component: Component, path }) => (
        <Route exact key={name} path={path} component={Component} />
      ))}
      <Route
        key="notFoundPage"
        path={location.pathname}
        render={notFoundPage}
      />
    </Switch>
  );
};
