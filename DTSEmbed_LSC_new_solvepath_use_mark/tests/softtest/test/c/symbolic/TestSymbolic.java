package softtest.test.c.symbolic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import softtest.config.c.Config;
import softtest.domain.c.symbolic.Expression;
import softtest.domain.c.symbolic.parser.*;
import softtest.test.c.symbolic.*;


@RunWith(Parameterized.class)
public class TestSymbolic
{
	private String source = null;
	private String expect = null;
	
	public TestSymbolic(String source,String expect) {
		this.source = source;
		this.expect=expect;
	}
	
	@BeforeClass
	public static void setUpBase()  {
		Config.TEST_SYMBOLIC=true;
	}

	@AfterClass
	public static void tearDownBase() {
	}
	
	@Before
	public void init() {
	}

	@After
	public void shutdown() {
	}
	
	@Test
	public void test() {
		Expression expr=SymbolicParser.parse(source);
		expr=expr.flatten(0);
		assertEquals("process \""+source+"\" error",expect,expr.toString());
	}
	
	@Parameters
	public static Collection<Object[]> testcaseAndResults(){
		return Arrays.asList(new Object[][] {
				/////////////////    0   ///////////////////
				{
					"2/2",
					"1",
				},	
				/////////////////    1   ///////////////////
				{
					"1",
					"1",
				},
				/////////////////    2   ///////////////////
				{
					"0",
					"0",
				},
				/////////////////    3   ///////////////////
				{
					"0+1",
					"1",
				},
				/////////////////    4   ///////////////////
				{
					"0+0",
					"0",
				},			
				/////////////////    5   ///////////////////
				{
					"1+0",
					"1",
				},					
				/////////////////    6   ///////////////////
				{
					"-1+1",
					"0",
				},					
				/////////////////    7   ///////////////////
				{
					"-2+1",
					"-1",
				},				
				/////////////////    8   ///////////////////
				{
					"1+1",
					"2",
				},	
				/////////////////    9   ///////////////////
				{
					"1+1+1",
					"3",
				},				
				/////////////////    10   ///////////////////
				{
					"3+2+1",
					"6",
				},				
				/////////////////    11   ///////////////////
				{
					"1+2+3",
					"6",
				},				
				/////////////////    12   ///////////////////
				{
					"1.0",
					"1.0",
				},			
				/////////////////    13   ///////////////////
				{
					"0.0",
					"0",
				},
				/////////////////    14   ///////////////////
				{
					"1.1+1.1",
					"2.2",
				},
				/////////////////    15   ///////////////////
				{
					"0+1.0",
					"1.0",
				},
				/////////////////    16   ///////////////////
				{
					"0.0+0.0",
					"0",
				},			
				/////////////////    17   ///////////////////
				{
					"1.0+0.0",
					"1.0",
				},					
				/////////////////    18   ///////////////////
				{
					"-1.0+1.0",
					"0",
				},					
				/////////////////    19   ///////////////////
				{
					"-2.0+1.0",
					"-1.0",
				},				
				/////////////////    20   ///////////////////
				{
					"1.0+1.0",
					"2.0",
				},	
				/////////////////    21   ///////////////////
				{
					"1.0+1.0+1.0",
					"3.0",
				},				
				/////////////////    22   ///////////////////
				{
					"3.0+2.0+1.0",
					"6.0",
				},				
				/////////////////    23   ///////////////////
				{
					"1.0+2.0+3.0",
					"6.0",
				},	
				/////////////////    24   ///////////////////
				{
					"1.0*1.0",
					"1",
				},	
				/////////////////    25   ///////////////////
				{
					"0*1.0",
					"0",
				},	
				/////////////////    26   ///////////////////
				{
					"2*2.0",
					"4.0",
				},	
				/////////////////    27   ///////////////////
				{
					"2*2.0*2",
					"8.0",
				},	
				/////////////////    28   ///////////////////
				{
					"2.0/2.0",
					"1",
				},	
				/////////////////    29   ///////////////////
				{
					"2.0/1.0",
					"2.0",
				},
				/////////////////    30   ///////////////////
				{
					"1/2",
					"0.5",
				},
				/////////////////    31   ///////////////////
				{
					"1.0/2",
					"0.5",
				},
				/////////////////    32   ///////////////////
				{
					"0/2",
					"0",
				},
				/////////////////    33   ///////////////////
				{
					"0/1",
					"0",
				},
				/////////////////    34   ///////////////////
				{
					"3*5/5.0",
					"3.0",
				},
				/////////////////    35   ///////////////////
				{
					"3*5.0/5",
					"3.0",
				},
				/////////////////    36   ///////////////////
				{
					"x/2",
					"0.5*x",
				},
				
				/////////////////    37   ///////////////////
				{
					"2^2",
					"4.0",
				},
				/////////////////    38   ///////////////////
				{
					"2^2^2",
					"16.0",
				},		
				/////////////////    39   ///////////////////
				{
					"2^0^2",
					"1.0",
				},	
				/////////////////    40   ///////////////////
				{
					"2^2^1",
					"4.0",
				},	
				/////////////////    41   ///////////////////
				{
					"x+x",
					"2*x",
				},
				/////////////////    42   ///////////////////
				{
					"x+x+x",
					"3*x",
				},
				/////////////////    43   ///////////////////
				{
					"x+x+y",
					"2*x+y",
				},
				/////////////////    44   ///////////////////
				{
					"3*x + 2*y + 2*x + 3*y",
					"5*x+5*y",
				},
				/////////////////    45   ///////////////////
				{
					"3*x*y+2*y*x",
					"5*x*y",
				},
				/////////////////    46   ///////////////////
				{
					"x-x",
					"0",
				},
				/////////////////    47   ///////////////////
				{
					"x-x-x",
					"-1*x",
				},
				/////////////////    48   ///////////////////
				{
					"x-x-y",
					"-1*y",
				},
				/////////////////    49   ///////////////////
				{
					"x-y-y",
					"x+-2*y",
				},
				/////////////////    50   ///////////////////
				{
					"y+x",
					"x+y",
				},
				/////////////////    51   ///////////////////
				{
					"3*x-2*x",
					"x",
				},
				/////////////////    52   ///////////////////
				{
					"2*x-3*x",
					"-1*x",
				},
				/////////////////    53   ///////////////////
				{
					"x^4*x^4",
					"x^8",
				},
				/////////////////    54   ///////////////////
				{
					"x*x^4",
					"x^5",
				},
				/////////////////    55   ///////////////////
				{
					"x/x",
					"1",
				},
				/////////////////    56   ///////////////////
				{
					"x^3/x^3",
					"1",
				},
				/////////////////    57   ///////////////////
				{
					"2*x*y/(4*x)",
					"0.5*y",
				},		
				/////////////////    58   ///////////////////
				{
					"x^10/x^7",
					"x^3",
				},	
				/////////////////    59   ///////////////////
				{
					"x^10/x",
					"x^9",
				},	
				/////////////////    60   ///////////////////
				{
					"x^2/x^6",
					"x^-4",
				},
				/////////////////    61   ///////////////////
				{
					"x/x^3",
					"x^-2",
				},
				/////////////////    62   ///////////////////
				{
					"y^3*x^2/(y*x^5)",
					"x^-3*y^2",
				},
				/////////////////    63   ///////////////////
				{
					"x^(-4)/x^(-7)",
					"x^3",
				},
				/////////////////    64   ///////////////////
				{
					"x^(-4)/x^7",
					"x^-11",
				},
				/////////////////    65   ///////////////////
				{
					"x^5/x^(-3)",
					"x^8",
				},		
				/////////////////    66   ///////////////////
				{
					"-1*(-x)",
					"x",
				},			
				/////////////////    67   ///////////////////
				{
					"-(-1+x^2-5+3)",
					"-1*(-3+x^2)",
				},	
				/////////////////    68   ///////////////////
				{
					"(-1)",
					"-1",
				},	
				/////////////////    69   ///////////////////
				{
					"(1)",
					"1",
				},	
				/////////////////    70   ///////////////////
				{
					"(-x)",
					"-1*x",
				},	
				/////////////////    71   ///////////////////
				{
					"(-1+x)",
					"-1+x",
				},	
			    /////////////////    72   ///////////////////
				{
					"z*3*x*y",
					"3*x*y*z",
				},
			    /////////////////    73   ///////////////////
				{
					"x*z*y+z*3*x*y-y*x*z",
					"3*x*y*z",
				},
			    /////////////////    74   ///////////////////
				{
					"-x",
					"-1*x",
				},
				
				
	            }
		);
	}
}

