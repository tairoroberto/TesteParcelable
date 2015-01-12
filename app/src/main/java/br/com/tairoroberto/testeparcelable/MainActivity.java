package br.com.tairoroberto.testeparcelable;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ArrayList<Student> students;
    private List<Discipline> disciplines;
    private Team team;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students = new ArrayList<Student>();


        //Obs: Ter cuidado com imagens grandes, se a imagem for muito grande ela não passa para a outra activity
        //Studant 1
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1,"Matemática"));
        disciplines.add(new Discipline(2,"Português"));
        team = new Team("time 1",15);
        student = new Student("Estudante 1",18, BitmapFactory.decodeResource(getResources(),R.drawable.student_3),team,disciplines);
        students.add(student);

        //Studant 2
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1,"Matemática"));
        disciplines.add(new Discipline(2,"História"));
        team = new Team("time 1",15);
        student = new Student("Estudante 2",17, BitmapFactory.decodeResource(getResources(),R.drawable.student_2),team,disciplines);
        students.add(student);

        //Studant 3
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1,"Geográfia"));
        disciplines.add(new Discipline(2,"Português"));
        team = new Team("time 1",15);
        student = new Student("Estudante 3",18, BitmapFactory.decodeResource(getResources(),R.drawable.student_3),team,disciplines);
        students.add(student);

        //Studant 4
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1,"Química"));
        disciplines.add(new Discipline(2,"Física"));
        team = new Team("time 1",15);
        student = new Student("Estudante 4",19, BitmapFactory.decodeResource(getResources(),R.drawable.student_4),team,disciplines);
        students.add(student);

        //Studant 5
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1,"Química"));
        disciplines.add(new Discipline(2,"Física"));
        team = new Team("time 1",15);
        student = new Student("Estudante 5",22, BitmapFactory.decodeResource(getResources(),R.drawable.student_5),team,disciplines);
        students.add(student);

        //Studant Tairo
        disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1,"Java"));
        disciplines.add(new Discipline(2,"Android"));
        disciplines.add(new Discipline(2,"Php"));
        disciplines.add(new Discipline(2,"Php e Laravel"));
        disciplines.add(new Discipline(2,"Cobol"));
        team = new Team("time 1",15);
        student = new Student("Tairo ",25, BitmapFactory.decodeResource(getResources(),R.drawable.student_5),team,disciplines);
        students.add(student);
    }

    public void callClass(View view){
        Intent intent = new Intent(MainActivity.this,ClassMainActivity.class);
        intent.putParcelableArrayListExtra("students",students);
        startActivity(intent);
    }
}
