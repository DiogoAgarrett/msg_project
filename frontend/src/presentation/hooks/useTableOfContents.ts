import { useState, useEffect } from 'react';
import type { TableOfContents } from '../../domain/TableOfContents';
import { getAllTableOfContentsUseCase } from '../../application/table-of-contents/dependencyInjection';

export const useTableOfContents = (bookCode: string, editionNumber: string) => {
  const [data, setData] = useState<TableOfContents | null>(null);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    if (!bookCode || !editionNumber) {
      setData(null);
      return;
    }

    const fetchData = async () => {
      try {
        setLoading(true);
        const result = await getAllTableOfContentsUseCase.execute(bookCode, editionNumber);
        setData(result);
        setError(null);
      } catch (err) {
        setError(err instanceof Error ? err.message : 'An error occurred');
        setData(null);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, [bookCode, editionNumber]);

  return { data, loading, error };
};