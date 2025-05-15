import React, { useState, useEffect } from 'react';
import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle,
    TextField,
    FormControl,
    InputLabel,
    Select,
    MenuItem
} from "@mui/material";
import useAuthors from "../../../../hooks/useAuthors.js";

const categories = [
    "NOVEL",
    "THRILER",
    "HISTORY",
    "FANTASY",
    "BIOGRAPHY",
    "CLASSICS",
    "DRAMA"
];
const EditBookDialog = ({ open, onClose, onEdit, book }) => {

    // const validate = () =>{
    //     if(book.name==""||book.category==""||book.author==""){
    //TODO: IMPLEMENT VALIDATE FUNCTION FOR EDIT
    //     }
    // }

    const [formData, setFormData] = useState({
        "name": book.name,
        "category":book.category,
        "author": book.author
    });
    const {authors}=useAuthors();
    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData(prev => ({ ...prev, [name]: value }));
    };

    const handleSubmit = () => {
        onEdit(book.id,formData);
        setFormData(formData)
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Edit Book</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    label="Name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    fullWidth
                />
                <FormControl fullWidth margin="dense">
                    <InputLabel>Category</InputLabel>
                    <Select
                        label="Category"
                        name="category"
                        value={formData.category}
                        onChange={handleChange}
                    >
                        {categories.map(cat => (
                            <MenuItem key={cat} value={cat}>{cat}</MenuItem>
                        ))}
                    </Select>
                </FormControl>
                <FormControl fullWidth margin="dense">
                    <InputLabel>Author</InputLabel>
                    <Select
                        label="Author"
                        name="author"
                        value={formData.author}
                        onChange={handleChange}
                    >
                        {authors.map(author => (
                            <MenuItem key={author.id} value={author.id}>
                                {author.name} {author.surname}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button
                    onClick={handleSubmit}
                    variant="contained"
                    color="primary"
                >
                    Save
                </Button>
            </DialogActions>
        </Dialog>
    );
};

export default EditBookDialog;
