import React from 'react';
import type { Entry } from '../../domain/Entry';

interface ContentEntryProps {
  entry: Entry;
  level?: number;
}

export const ContentEntry: React.FC<ContentEntryProps> = ({ entry, level = 0 }) => {
  const indent = level * 20;

  return (
    <div style={{ marginLeft: `${indent}px`, marginBottom: '8px' }}>
      <div style={{ fontWeight: level === 0 ? 'bold' : 'normal' }}>
        {entry.title}
      </div>
      {entry.children.length > 0 && (
        <div>
          {entry.children
            .sort((a, b) => a.order - b.order)
            .map((child) => (
              <ContentEntry key={child.id} entry={child} level={level + 1} />
            ))}
        </div>
      )}
    </div>
  );
};