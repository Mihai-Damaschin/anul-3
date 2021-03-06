import { lazy as $lazy } from "react";

import { HomePage } from "features/home/pages/HomePage";
import { CaesarPage } from "features/criptare/pages/CaesarPage";
import { Test1 } from "./features/threejs/pages/Test1";

export const lazy = (feature: string, page: string) =>
  $lazy(() => import(`features/${feature}/pages/${page}`));

export interface Route {
  name: string;
  label?: string;
  icon?: string;
  path?: string;
  component?: () => JSX.Element;
  children?: Route[];
}

export const routes: Route[] = [
  {
    name: "HomePage",
    label: "Home",
    icon: "home",
    path: "/",
    component: HomePage,
  },
  {
    name: "EncryptionCategory",
    label: "Criptare",
    icon: "lock",
    children: [
      {
        name: "CaesarPage",
        label: "Caesar",
        path: "/criptare/caesar",
        component: CaesarPage,
      },
    ],
  },
  {
    name: "TestCategory",
    label: "Experimental",
    icon: "lock",
    children: [
      {
        name: "ThreeJsPage",
        label: "Three.js",
        path: "/threejs/test1",
        component: Test1,
      },
    ],
  },
];
