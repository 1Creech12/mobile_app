import { useEffect, useRef } from "react";
import { SAVE_DELAY } from "@/constants/app.constants";

export default function useDebounce() {
    const saveTimeout = useRef<ReturnType<typeof setTimeout> | null>(null);

    const debouncedSave = (func: () => void) => {
        if (saveTimeout.current) {
            clearTimeout(saveTimeout.current);
        }

        saveTimeout.current = setTimeout(() => {
            func();
        }, SAVE_DELAY);
    };

    useEffect(() => {
        return () => {
            if (saveTimeout.current) {
                clearTimeout(saveTimeout.current);
            }
        };
    }, []);

    return debouncedSave;
};
