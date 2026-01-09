import { useState, useEffect } from 'react';
import type { EditionDTO } from '../../application/dtos/EditionDTO';
import { getEditionsByBookUseCase } from '../../application/table-of-contents/dependencyInjection';


export const useEditions = (bookCode: string | null) => {
  const [editions, setEditions] = useState<EditionDTO[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    if (!bookCode) {
      setEditions([]);
      return;
    }

    const fetchEditions = async () => {
      try {
        setLoading(true);
        const result = await getEditionsByBookUseCase.execute(bookCode);
        setEditions(result);
        setError(null);
      } catch (err) {
        setError(err instanceof Error ? err.message : 'An error occurred');
        setEditions([]);
      } finally {
        setLoading(false);
      }
    };

    fetchEditions();
  }, [bookCode]);

  return { editions, loading, error };
};