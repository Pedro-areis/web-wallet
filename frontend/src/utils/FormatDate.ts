export const formatDate = (date: Date | undefined) => {
    return date ? new Date(date).toLocaleDateString("pt-BR") : "Data não disponível";
}