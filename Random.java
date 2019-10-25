public class Random{

    private int array[];
    private int count;


    /**
     * Constructor method. Sets 'random numbers' to each value of array.
     */
    public Random(){

        array = new int[22];
        array[0] = 1804289383;
        array[1] = 846930886;
        array[2] = 1681692777;
        array[3] = 1714636915;
        array[4] = 1957747793;
        array[5] = 424238335;
        array[6] = 719885386;
        array[7] = 1649760492;
        array[8] = 596516649;
        array[9] = 1189641421;
        array[10] = 1025202362;
        array[11] = 1350490027;
        array[12] = 783368690;
        array[13] = 1102520059;
        array[14] = 2044897763;
        array[15] = 1967513926;
        array[16] = 1365180540;
        array[17] = 1540383426;
        array[18] = 304089172;
        array[19] = 1303455736;
        array[20] = 35005211;
        array[21] = 521595368;

        count = 0;

    }


    /**
     * Cycles through the array to return the next value.
     * @return : array[count-1]
     */
    public int rand(){
        if (count<22){
            count ++;
        }
        else{
            count = 0;
        }
        return array[count-1];

    }
}

