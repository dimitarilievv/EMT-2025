import React from 'react';
import { useNavigate, useParams } from "react-router";
import useBookDetails from "../../../../hooks/useBookDetails.js";
import {
    Box,
    Button,
    Breadcrumbs,
    CircularProgress,
    Grid,
    Link,
    Paper,
    Typography
} from "@mui/material";
import {
    ArrowBack,
    Share
} from "@mui/icons-material";

const BookDetails = () => {
    const navigate = useNavigate();
    const { id } = useParams();
    const { book } = useBookDetails(id);
    if (!book) {
        return (
            <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '60vh' }}>
                <CircularProgress />
            </Box>
        );
    }

    return (
        <Box>
            <Breadcrumbs aria-label="breadcrumb" sx={{ mb: 3 }}>
                <Link
                    underline="hover"
                    color="inherit"
                    href="#"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate("/books");
                    }}
                >
                    Books
                </Link>
                <Typography color="text.primary">{book.name}</Typography>
            </Breadcrumbs>

            <Paper elevation={2} sx={{ p: 4, borderRadius: 4 }}>
                <Grid container spacing={4}>
                    <Grid item xs={12} md={9}>
                        <Box sx={{ mb: 3 }}>
                            <Typography variant="h5" gutterBottom sx={{ fontWeight: 600 }}>
                                Book name: {book.name}
                            </Typography>
                            <Typography variant="h6" gutterBottom>
                                Category: {book.category}
                            </Typography>
                            <Typography variant="h6" gutterBottom>
                                Author: {book.author ? book.author.name : "Unknown"}
                            </Typography>X
                        </Box>
                    </Grid>
                    <Grid item xs={12} display="flex" justifyContent="space-between">
                        <Button
                            variant="outlined"
                            startIcon={<Share />}
                        >
                            Share
                        </Button>
                        <Button
                            variant="outlined"
                            startIcon={<ArrowBack />}
                            onClick={() => navigate("/books")}
                        >
                            Back to Books
                        </Button>
                    </Grid>
                </Grid>
            </Paper>
        </Box>
    );
};

export default BookDetails;
