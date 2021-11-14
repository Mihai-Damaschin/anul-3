import { Suspense } from "react";
import { BrowserRouter } from "react-router-dom";
import { SuspenseLoading } from "./molecules";
import { Routes } from "libs/router/Routes";
import { MainLayout } from "./organisms/Layout/Layout";

export const App = () => {
  return (
    <BrowserRouter>
      <Suspense fallback={<SuspenseLoading />}>
        <MainLayout>
          <Routes />
        </MainLayout>
      </Suspense>
    </BrowserRouter>
  );
};
