import React from 'react';
import { ContentEntry } from './ContentEntry';
import type { TableOfContents as TableOfContentsEntity } from '../../domain/TableOfContents';

interface TableOfContentsProps {
  data: TableOfContentsEntity;
}

export const TableOfContents: React.FC<TableOfContentsProps> = ({ data }) => {
  return (
    <div style={{ padding: '20px' }}>
      <h1>Title: {data.book.title}</h1>
      <h2>Edition: {data.edition.editionName}</h2>
      
      <div style={{ marginTop: '20px' }}>
        {data.entries
          .sort((a, b) => a.order - b.order)
          .map((entry) => (
            <ContentEntry key={entry.id} entry={entry} />
          ))}
      </div>
      <p>Total Entries: {data.totalEntries}</p>
    </div> 
  );
};