import React, { useState } from 'react';
import { Box, Button, CircularProgress } from "@mui/material";
import useBooks from "../../../hooks/useBooks.js";
import "./BooksPage.css";
import AddBookDialog from "../../components/books/AddBookDialog/AddBookDialog.jsx";
import BooksGrid from "../../components/books/BooksGrid/BooksGrid.jsx";
import useAuthors from "../../../hooks/useAuthors.js";

const BooksPage = () => {
    const { books, loading, onAdd, onEdit, onDelete } = useBooks();
    const [addBookDialogOpen, setAddBookDialogOpen] = useState(false);
    const { authors } = useAuthors();

    return (
        <>
            <Box className="books-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress />
                    </Box>
                )}
                {!loading &&
                    <>
                        <Box sx={{ display: "flex", justifyContent: "flex-end", mb: 2 }}>
                            <Button variant="contained" color="primary" onClick={() => setAddBookDialogOpen(true)}>
                                Add Book
                            </Button>
                        </Box>
                        <BooksGrid books={books} onEdit={onEdit} onDelete={onDelete} />
                    </>
                }
            </Box>
            <AddBookDialog
                open={addBookDialogOpen}
                onClose={() => setAddBookDialogOpen(false)}
                authors={authors}
                onAdd={onAdd}
            />
        </>
    );
};

export default BooksPage;
