package day1.case1.test_useOfClass;

import day1.case1.Class.Movie;

import java.util.Scanner;

public class MovieService {
    private Movie[] movies;

    private Scanner sc=new Scanner(System.in);


    public MovieService(Movie[] movies) {
        this.movies=movies;
    }

    public void start() {
        lo :
        while (true) {
            System.out.println("-----电影信息系统-----");
            System.out.println("请输入您的选择 ");
            System.out.println("1,查询全部电影信息");
            System.out.println("2.根据id查询电影信息");
            System.out.println("3.退出");

            int choice=sc.nextInt();

            switch (choice){
                case 1 :
                    queryMovieInfos();
                    break;
                case 2 :
                    queryMovieInfoById();
                    break;
                case 3 :
                    System.out.println("感谢您的使用，再见！");
                    break lo;
                default :
                    System.out.println("您的输入有误，请检查");
                    break;
            }
        }
    }

    private void queryMovieInfoById() {
        System.out.println("请输入您要查询的电影编号：");
        int id=sc.nextInt();
        for (int i = 0; i < movies.length; i++) {
            Movie movie =movies[i];
            if(movie.getId()==id){
                System.out.println(movie.getId()+"---"+movie.getTitle()+"---"+movie.getScore()
                +"---"+movie.getArea()+"---"+movie.getType()+"---"+movie.getDirector()+"---"+movie.getStarring());
                return;
            }
        }
        System.out.println("您输入的编号不存在，请检查！");
    }

    private void queryMovieInfos() {
        for (int i = 0; i < movies.length; i++) {
            Movie movie=movies[i];
            System.out.println(movie.getTime()+"---"+movie.getScore());
        }
    }
}
