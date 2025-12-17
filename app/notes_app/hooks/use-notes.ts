import { Note } from "@/note";
import { useLocalSearchParams, useRouter } from "expo-router";
import { useState } from "react";
import useAsyncStorage from "./use-storage";
import { STOREGE_KEY } from "../constants/app.constants";

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

  const updateText = async (text: string) => {
    if (!note) return;

    const updated: Note = { ...note, text };
    setNote(updated);

    const saved = await getItems(STOREGE_KEY);
    if (!saved) return;

    const list: Note[] = await getItems(STOREGE_KEY);
    const newList = list.map((n) => (n.id === note.id ? updated : n));

    await setItems(STOREGE_KEY, newList);
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