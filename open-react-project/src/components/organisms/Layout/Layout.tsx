import { FC, useCallback, useMemo } from "react";
import { useHistory, useLocation } from "react-router-dom";
import { Sidebar, Layout, Icon } from "ebs-design";
import { getActiveRouteByPath } from "libs/router/routerHelpers";
import { routes } from "../../../routes";

export const MainLayout: FC = ({ children }) => {
  const { pathname } = useLocation();
  const { push } = useHistory();

  const currentRouteName = useMemo(
    () => getActiveRouteByPath(pathname),
    [pathname]
  );

  const onItemClick = useCallback((url?: string) => url && push(url), []);

  return (
    <div className="m-$Layout">
      <Layout>
        <Sidebar>
          <Sidebar.TopMenu>
            {routes.map((i) => (
              <Sidebar.Item
                key={i.name}
                prefix={Boolean(i.icon) && <Icon type={i.icon} />}
                text={i.label}
                onClick={() => onItemClick(i.path)}
                active={
                  i.children
                    ? Boolean(getActiveRouteByPath(pathname, i.children))
                    : i.name === currentRouteName
                }
              >
                {i.children &&
                  i.children.map((i) => (
                    <Sidebar.Item
                      key={i.name}
                      text={i.label}
                      active={i.name === currentRouteName}
                      onClick={() => onItemClick(i.path)}
                    />
                  ))}
              </Sidebar.Item>
            ))}
          </Sidebar.TopMenu>
        </Sidebar>

        <Layout.Content>{children}</Layout.Content>
        <Layout.Footer
          label={
            <>
              Created by <b>Mishanea</b>
            </>
          }
          fixed
        />
      </Layout>
    </div>
  );
};
