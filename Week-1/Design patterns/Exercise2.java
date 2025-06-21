import java.util.*;

public class Exercise2 {
    public static void main(String[] args){
        new FactoryTest().runTests();
    }
}

class FactoryTest{
    void runTests(){
        ConcreteDocumentFactory cdf=new ConcreteDocumentFactory();
        Document d1=cdf.createDocument("pdf");
        d1.describe();
        Document d2=cdf.createDocument("excel");
        d2.describe();
        Document d3=cdf.createDocument("word");
        d3.describe();
    }
}

interface Document{
    void describe();
}

class WordDocument implements Document{

    @Override
    public void describe() {
        System.out.println("This is a word document");
    }
}

class PdfDocument implements Document{

    @Override
    public void describe(){
        System.out.println("This is a pdf document");
    }
}

class ExcelDocument implements Document{
    @Override
    public void describe(){
        System.out.println("This is an excel document");
    }
}

abstract class DocumentFactory{
    public abstract Document createDocument(String docType);
}

class ConcreteDocumentFactory extends DocumentFactory{

    @Override
    public Document createDocument(String docType) {
        docType=docType.trim();
        if(docType.equalsIgnoreCase("WORD")){
            return new WordDocument();
        }
        else if(docType.equalsIgnoreCase("PDF")){
            return new PdfDocument();
        }
        else if(docType.equalsIgnoreCase("EXCEL")){
            return new ExcelDocument();
        }
        else{
            return null;
        }
    }
}