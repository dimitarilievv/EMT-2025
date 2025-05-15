import React, {useState} from 'react';
import {Box, Button, CircularProgress} from "@mui/material";
import AuthorsGrid from "../../components/authors/AuthorsGrid/AuthorsGrid.jsx";
import useAuthors from "../../../hooks/useAuthors.js";
import "./AuthorsPage.css";
import AddAuthorDialog from "../../components/authors/AddAuthorDialog/AddAuthorDialog.jsx";

const AuthorsPage = () => {
    const {authors, loading, onAdd, onEdit, onDelete} = useAuthors();
    const [addAuthorsDialogOpen, setAddAuthorsDialogOpen] = useState(false);

    return (
        <>
            <Box className="authors-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}
                {!loading &&
                    <>
                        <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                            <Button variant="contained" color="primary" onClick={() => setAddAuthorsDialogOpen(true)}>
                                Add Author
                            </Button>
                        </Box>
                        <AuthorsGrid authors={authors} onEdit={onEdit} onDelete={onDelete}/>
                    </>}
            </Box>
            <AddAuthorDialog
                open={addAuthorsDialogOpen}
                onClose={() => setAddAuthorsDialogOpen(false)}
                onAdd={onAdd}
            />
        </>
    );
};

export default AuthorsPage;
