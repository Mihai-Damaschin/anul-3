import { routes as $routes } from "../../routes";

export const clearRoutes = $routes
  .map((i) => (i.children?.length ? [i, ...i.children] : i))
  .flat()
  .filter((i) => i.path && i.component);

export const getActiveRouteByPath = (
  path: string,
  routes = clearRoutes
): string => {
  const activeRoute = routes.find((i) => comparePaths(i.path || "", path));

  return activeRoute ? activeRoute.name : "";
};

export const comparePaths = (path1: string, path2: string) => {
  const path2Array = path2.split("/");
  let isRightPath = true;

  path1.split("/").map((i, key) => {
    if (i.includes(":") && path2Array[key]) {
      return i;
    }

    if (i !== path2Array[key]) {
      isRightPath = false;
    }

    return i;
  });

  return isRightPath;
};
