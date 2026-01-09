import React, { useState } from 'react';
import { useBooks } from '../hooks/useBooks';
import { useEditions } from '../hooks/useEditions';
import { useTableOfContents } from '../hooks/useTableOfContents';
import { TableOfContents } from '../components/TableOfContents';

export const Book: React.FC = () => {
  const [selectedBook, setSelectedBook] = useState<string | null>(null);
  const [selectedEdition, setSelectedEdition] = useState<string | null>(null);

  const { books, loading: booksLoading } = useBooks();
  const { editions, loading: editionsLoading } = useEditions(selectedBook);
  const { data, loading: dataLoading, error } = useTableOfContents(
    selectedBook || '',
    selectedEdition || ''
  );

  const shouldFetchData = selectedBook && selectedEdition;

  return (
    <div style={{ padding: '20px' }}>
      <h1>Book Table of Contents</h1>

      <div style={{ marginBottom: '20px' }}>
        <label htmlFor="book-select">Select Book: </label>
        <select
          id="book-select"
          value={selectedBook || ''}
          onChange={(e) => {
            setSelectedBook(e.target.value);
            setSelectedEdition(null);
          }}
          disabled={booksLoading}
        >
          <option value="">-- Select a book --</option>
          {books.map((book) => (
            <option key={book.code} value={book.code}>
              {book.title}
            </option>
          ))}
        </select>
      </div>

      {selectedBook && (
        <div style={{ marginBottom: '20px' }}>
          <label htmlFor="edition-select">Select Edition: </label>
          <select
            id="edition-select"
            value={selectedEdition || ''}
            onChange={(e) => setSelectedEdition(e.target.value)}
            disabled={editionsLoading}
          >
            <option value="">-- Select an edition --</option>
            {editions.map((edition) => (
              <option key={edition.editionNumber} value={edition.editionNumber}>
                {edition.editionName}
              </option>
            ))}
          </select>
        </div>
      )}

      {shouldFetchData && (
        <>
          {dataLoading && <div>Loading table of contents...</div>}
          {error && <div>Error: {error}</div>}
          {data && <TableOfContents data={data} />}
        </>
      )}
    </div>
  );
};