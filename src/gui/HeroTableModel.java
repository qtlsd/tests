package gui;

import javax.swing.table.AbstractTableModel;
import JDBC.ORM;

import java.util.List;
import mutiThread.Hero;

public class HeroTableModel extends AbstractTableModel {
    String[] columNames = new String[]{"id", "name", "hp", "damage"};
    public List<Hero> heros = ORM.list();


    //一共多少列
    @Override
    public int getColumnCount() {
        return columNames.length;
    }

    //一共多少行
    @Override
    public int getRowCount() {
        return heros.size();
    }

    //每一个单元格里的值
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hero h = heros.get(rowIndex);
        if(columnIndex==0)
            return h.id;
        if(columnIndex==1)
            return h.name;
        if(columnIndex==2)
            return h.hp;
        if(columnIndex==3)
            return h.damage;
        return null;

    }

    //返回列名
    @Override
    public String getColumnName(int column) {
        return columNames[column];
    }

    //单元格是否可修改
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
