public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("Factory Method Pattern");
        System.out.println();
        WordDocumentFactory wd = new WordDocumentFactory();
        Document word = wd.createDocument();
        word.open();
        word.close();

        ExcelDocumentFactory ed = new ExcelDocumentFactory();
        Document excel = ed.createDocument();
        excel.open();
        excel.close();

        PdfDocumentFactory pd = new PdfDocumentFactory();
        Document pdf = pd.createDocument();
        pdf.open();
        pdf.close();
    }
}
