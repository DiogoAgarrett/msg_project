export interface EntryDTO {
    id: string;
    title: string;
    order: number;
    children: EntryDTO[];
}