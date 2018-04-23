package org.sknn.hello.listview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.sknn.hello.R;
import org.sknn.hello.listview.bean.Fruit;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceid;

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceid = resource;
    }

    /**
     * 在每个子项被滚动到屏幕内的时候会被调用
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;

        // 对每次滑动都重新加载进行优化, 如果已经创建了, 使用以前的视图
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceid, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitIamge = view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = view.findViewById(R.id.fruit_text);
            // set 存储一下
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        // 为每个子项加载每次加载自定义的布局
        // 第三个false表示, 只让在父布局中声明的layout属性生效, 但不为这个View添加父布局. ListView标准写法.
        // 一旦view有了父布局之后, 他就不能再添加到LiatView中了, 否则会报
        // ArrayAdapter requires the resource ID to be a TextView 错误.
        //View view = LayoutInflater.from(getContext()).inflate(resourceid, parent, false);

        // 第二步优化, 不必每个子项都使用findviewbyid, 优化加载速度
        /*((ImageView) view.findViewById(R.id.fruit_image)).setImageResource(fruit.getId());
        ((TextView) view.findViewById(R.id.fruit_text)).setText(fruit.getName());*/

        viewHolder.fruitIamge.setImageResource(fruit.getId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder {
        ImageView fruitIamge;
        TextView fruitName;
    }
}
