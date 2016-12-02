//############################
//# Name: Leo Gomez          #
//# CruzID: legomez          #
//# Class: CMPS-12B          #
//# Date: Nov 5, 2014        #
//# filename:dllistTest.java #
//# Details:allows me to test#
//#    my dllist.java file   #
//############################

// dllistTest.java
// Unit tests for dllist

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class dllistTest {

    @Test
    public void startsEmptyTest() {
        dllist lst = new dllist();
        assertEquals(true, lst.isEmpty());
    }

	@Test
	public void secondTest()
	{
		dllist lst = new dllist();
		lst.insert("Hello",dllist.Position.LAST);
		assertEquals(false, lst.isEmpty());
	}

	@Test
	public void thirdTest()
	{
		dllist lst = new dllist();
		lst.insert("Hello",dllist.Position.LAST);
		assertEquals("Hello",lst.getItem());
	}

	@Test
	public void fourthTest()
	{
		dllist lst = new dllist();
		lst.insert("Hello",dllist.Position.LAST);
		lst.insert("My",dllist.Position.LAST);
		assertEquals("My", lst.getItem());
	}

	@Test
	public void fifthTest()
	{
		dllist lst = new dllist();
		lst.insert("Hello",dllist.Position.LAST);
		lst.insert("my",dllist.Position.LAST);
		lst.insert("name",dllist.Position.FOLLOWING);
		assertEquals(1, lst.getPosition());
	}

	@Test
	public void sixthTest()
	{
		dllist lst = new dllist();
                lst.insert("Hello",dllist.Position.PREVIOUS);
                lst.insert("my",dllist.Position.PREVIOUS);
		lst.setPosition(dllist.Position.FOLLOWING);
                assertEquals("Hello", lst.getItem());
	}

       @Test
        public void seventhTest()
        {
                dllist lst = new dllist();
                lst.insert("Hello",dllist.Position.FOLLOWING);
                lst.insert("my",dllist.Position.FOLLOWING);
		lst.setPosition(dllist.Position.FIRST);
                assertEquals("my", lst.getItem());
        }

       @Test
        public void eighthTest()
        {
                dllist lst = new dllist();
                lst.insert("Hello",dllist.Position.PREVIOUS);
                lst.insert("my",dllist.Position.PREVIOUS);
		lst.setPosition(dllist.Position.FIRST);
                assertEquals("Hello", lst.getItem());
        }
	
      @Test
        public void ninthTest()
        {
                dllist lst = new dllist();
		lst.setPosition(dllist.Position.FIRST);
        }

     	 @Test
        public void tenthTest()
        {
                dllist lst = new dllist();
                lst.insert("A",dllist.Position.LAST);
                lst.insert("B",dllist.Position.LAST);
                lst.insert("C",dllist.Position.LAST);
                lst.insert("D",dllist.Position.FOLLOWING);
                lst.setPosition(dllist.Position.LAST);
                assertEquals("C", lst.getItem());
        }

	@Test
        public void abcTest()
        {
                dllist lst = new dllist();
                lst.insert("A",dllist.Position.FIRST);
                lst.insert("B",dllist.Position.FIRST);
                lst.insert("C",dllist.Position.FIRST);
                lst.insert("D",dllist.Position.PREVIOUS);
                lst.setPosition(dllist.Position.FIRST);
                assertEquals("C", lst.getItem());
        }

	@Test
        public void previousTest()
        {
		dllist lst = new dllist();
                lst.insert("D",dllist.Position.PREVIOUS);
        }

        @Test
        public void randomTest()
        {
                dllist lst = new dllist();
                lst.insert("Hill",dllist.Position.LAST);
                lst.insert("Jimmy",dllist.Position.LAST);
                lst.insert("Alice",dllist.Position.LAST);
                lst.insert("Donkeykong",dllist.Position.LAST);
        	lst.setPosition(dllist.Position.FIRST);
		lst.setPosition(dllist.Position.PREVIOUS);
                lst.setPosition(dllist.Position.PREVIOUS);
		lst.setPosition(dllist.Position.PREVIOUS);
		lst.setPosition(dllist.Position.FOLLOWING);
                lst.setPosition(dllist.Position.FOLLOWING);
                lst.setPosition(dllist.Position.FOLLOWING);
                assertEquals("Hill", lst.getItem());
        }

       @Test
        public void randompositionTest()
        {
                dllist lst = new dllist();
                lst.insert("Hill",dllist.Position.LAST);
                lst.insert("Jimmy",dllist.Position.LAST);
                lst.insert("Alice",dllist.Position.LAST);
                lst.insert("Donkeykong",dllist.Position.LAST);
                lst.setPosition(dllist.Position.FIRST);
                lst.setPosition(dllist.Position.PREVIOUS);
                lst.setPosition(dllist.Position.PREVIOUS);
                lst.setPosition(dllist.Position.PREVIOUS);
                lst.setPosition(dllist.Position.FOLLOWING);
                lst.setPosition(dllist.Position.FOLLOWING);
                lst.setPosition(dllist.Position.FOLLOWING);
                assertEquals(0, lst.getPosition());
        }

	@Test
	public void getposTest()
	{
		dllist lst = new dllist();
		lst.getPosition();
	}

        @Test
        public void deleteTest()
        {
                dllist lst = new dllist();
                lst.insert("A",dllist.Position.LAST);
                lst.insert("B",dllist.Position.LAST);
                lst.insert("C",dllist.Position.LAST);
                lst.insert("D",dllist.Position.LAST);
		lst.delete();
		assertEquals("C", lst.getItem());
        }

        @Test
        public void deletepostionTest()
        {
                dllist lst = new dllist();
                lst.insert("A",dllist.Position.FIRST);
                lst.insert("B",dllist.Position.FIRST);
                lst.insert("C",dllist.Position.FIRST);
                lst.insert("D",dllist.Position.FIRST);
                lst.setPosition(dllist.Position.LAST);
                lst.delete();
                assertEquals(2, lst.getPosition());
        }

}
