import { useEffect, useRef } from "react";

export const useDebounce = (
  callback: () => void,
  delay: number,
  dependencies: any[] = []
) => {
  const timer = useRef<NodeJS.Timer>();

  useEffect(() => {
    timer.current = setTimeout(callback, delay);

    return () => {
      if (timer.current) {
        clearTimeout(timer.current);
      }
    };
  }, [delay, ...dependencies]);
};
