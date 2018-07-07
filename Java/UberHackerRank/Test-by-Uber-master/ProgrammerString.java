# Test-by-Uber

public class ProgrammerString
{
    public static int programmerStrings(String s)
    {
        int lettersFromProgrammerOccurrences = 0;
        String searchedForWord = new String("programmer");
        int mCounter = 0;
        int rCounter = 0;
        int endOfFirstWord = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==searchedForWord.charAt(lettersFromProgrammerOccurrences)){
                if(searchedForWord.charAt(lettersFromProgrammerOccurrences)=='m')mCounter++;
                if(searchedForWord.charAt(lettersFromProgrammerOccurrences)=='r')rCounter++;
                if(mCounter!=2&&rCounter!=2&&rCounter!=4&&rCounter!=5) {
                    lettersFromProgrammerOccurrences++;
                    if(lettersFromProgrammerOccurrences==searchedForWord.length())
                    {
                        endOfFirstWord=i;
                        i=s.length();
                    }
                    else{i = 0;}
                }
            }
        }
        rCounter=0;
        mCounter=0;
        int beginningOfSecondWord=0;
        lettersFromProgrammerOccurrences=searchedForWord.length()-1;
        for (int i = s.length()-1; i > endOfFirstWord; i--) {
            if(s.charAt(i)==searchedForWord.charAt(lettersFromProgrammerOccurrences)){
                if(searchedForWord.charAt(lettersFromProgrammerOccurrences)=='m')mCounter++;
                if(searchedForWord.charAt(lettersFromProgrammerOccurrences)=='r')rCounter++;
                if(mCounter!=2&&rCounter!=2&&rCounter!=4) {
                    lettersFromProgrammerOccurrences--;
                    if(lettersFromProgrammerOccurrences==-1)
                    {
                        beginningOfSecondWord=i;
                        i=endOfFirstWord;
                    }
                    else{i = s.length()-1;}
                }
            }
        }
        return beginningOfSecondWord-endOfFirstWord-1;
    }
}
