package softtest.symboltable.c;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import softtest.ast.c.ASTTranslationUnit;
import softtest.ast.c.CCharStream;
import softtest.ast.c.CParser;
import softtest.ast.c.ParseException;

public class SymbolTableTest {
	public static void main(String[] args) throws ParseException, FileNotFoundException {
		CParser parser = CParser.getParser(new CCharStream(new FileReader("E:\\TESTCASE\\µ¥ÔªÄÚ\\2.c")));
		ASTTranslationUnit astroot=parser.TranslationUnit();
		astroot.jjtAccept(new OccurrenceAndExpressionTypeFinder(), null);
		System.out.println((AbstractScope)astroot.getScope());
	}

}
