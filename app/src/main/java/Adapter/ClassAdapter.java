package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.com.tairoroberto.testeparcelable.R;
import br.com.tairoroberto.testeparcelable.Student;

/**
 * Created by tairo on 12/01/15.
 */
public class ClassAdapter extends BaseAdapter {
    private Context context;
    private List<Student> list;
    private LayoutInflater inflater;

    public ClassAdapter(Context context, List<Student> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.student,null);
        Student student = list.get(position);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        imageView.setImageBitmap(student.getImage());

        TextView textView = (TextView) view.findViewById(R.id.name);
        textView.setText(student.getName());

        textView = (TextView)view.findViewById(R.id.age);
        textView.setText(student.getAge()+"");

        textView = (TextView)view.findViewById(R.id.team);
        textView.setText(student.getTeam().getName());

        textView = (TextView)view.findViewById(R.id.disciplines);
        textView.setText(student.getDisciplinesAsString()+"");

        return view;
    }
}
