public class kyp extends serVivo{
    int num;        //Como hay mucho kyp y todos son iguales los agruparemos y esta 
                    //variable sera el numero de kpy que nacieron ese dia y siguen vivios
    public kyp(int dia, int masaM, float probRepro, float probM, int num){
        super(dia,masaM,probRepro,probM,"kyp");
        this.num=num;
    }
}
