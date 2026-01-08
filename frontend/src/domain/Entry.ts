export interface Entry {
    id: string;
    title: string;
    order: number;
    children: Entry[];
}