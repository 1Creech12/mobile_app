import { Note } from "@/note";
import { useLocalSearchParams, useRouter } from "expo-router";
import { use, useEffect, useState } from "react";
import useAsyncStorage from "./use-storage";
import { STOREGE_KEY } from "../constants/app.constants";
import { debounce } from "./use-debounce";

const SAVE_DELAY = 1000; // Задержка перед сохранением изменений (в миллисекундах)

export default function useNotes() {
  const [notes, setNotes] = useState<Note[]>([]);
  const [note, setNote] = useState<Note | null>(null);
  const { id } = useLocalSearchParams<{ id: string }>();
  const router = useRouter();

  const { getItem, getItems, setItems,updateItem, deleteItem } = useAsyncStorage<Note>()

  const loadNotes = async () => {
    const saved = await getItems(STOREGE_KEY);
    setNotes(saved);
  };

  const createNote = async () => {
    const id = Date.now().toString();
    const newNote: Note = {
      id,
      text: "",
      createdAt: Date.now(),
    };

    const updated = [newNote, ...notes];
    setNotes(updated);
    await setItems(STOREGE_KEY, updated);

    router.push(`/note/${id}`);
  };

  const loadNote = async () => {
    const data = await getItem(STOREGE_KEY, "id", id);

    setNote(data);
  };

  const saveNote = async (updateNote: Note) => {
    const updatedList = await updateItem(
      STOREGE_KEY,
      "id",
      id,
      () => updateNote
    );
    setNotes(updatedList);
  }

  useEffect(() => {
    return () => {
      if (saveTimeout.current) {
        clearTimeout(saveTimeout.current);
      }

  const updateText = (text: string) => {
    if (!note) return;

    const updatedNote: Note = { ...note, text };
    setNote(updated);

    if (saveTimeout.current) {
      clearTimeout(saveTimeout.current);
    }

    saveTimeout.current = setTimeout(() => {
      saveNote(updated)
    }, SAVE_DELAY);
  };

  const deleteNote = async (id: string) => {
    
    const updatedList = await deleteItem(
      STOREGE_KEY,
      "id",
      id
    );
    setNotes(updatedList);
  }
  return {
    notes,
    note,
    createNote,
    loadNotes,
    updateText,
    loadNote,
    deleteNote
  }
}