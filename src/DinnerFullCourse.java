public class DinnerFullCourse {
    private Dish[] list = new Dish[5];
    
    public DinnerFullCourse(){

        list[0] = new Dish();
		list[0].setName("特選シーザサラダ");
		list[0].setValune(10);

		list[1] = new Dish();
		list[1].setName("銀しゃり");
		list[1].setValune(2);
		
		list[2] = new Dish();
		list[2].setName("梅干し");
		list[2].setValune(20);

        list[3] = new Dish();
        list[3].setName("スープ");
        list[3].setValune(25);

        list[4] = new Dish();
        list[4].setName("〆ラーメン");
        list[4].setValune(75);
    }

    public void eatAll(){
        String str = "";
        for(Dish dish : list){
            str += dish.getName() + "：" + dish.getValune() + " | =>" ;
        }
        System.out.println("今日のメニューは" + str + "です。");
    }

    public static void main(String[] args) {

		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}
}
