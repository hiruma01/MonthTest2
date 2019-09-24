package dao;

import studentinfo_daomain.StudentInfo;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudengtInfoImpl implements StudentInfoDao {
    @Override
    public List<StudentInfo> getList() {
        List<StudentInfo> list = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        String sql = "select * from studentinfo where flag='0'";
        PreparedStatement pdst = null;


        try {
            conn = DBUtils.getConnecion();
            pdst = conn.prepareStatement(sql);
            rs = pdst.executeQuery();
            while(rs.next()){
                 /*

    CREATE TABLE `studentinfo` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `name` varchar(64) DEFAULT NULL,
      `sex` char(1) DEFAULT NULL,
      `age` int(11) DEFAULT NULL,
      `ys` varchar(32) DEFAULT NULL,
      `class` varchar(64) DEFAULT NULL,
      `hiredate` date DEFAULT NULL,
      `tel` varchar(32) DEFAULT NULL,
      `jg` varchar(32) DEFAULT NULL,
      `flag` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`)

      CREATE TABLE `studentinfo` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(64) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `ys` varchar(32) DEFAULT NULL,
  `class` varchar(64) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `jg` varchar(32) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    )
     */
                //逐列获取
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                String ys = rs.getString("ys");
                String aClass = rs.getString("class");
                //java.sql.date
                //Date hiredate = rs.getDate("hiredate");
                String hiredate = rs.getString("hiredate");
                String tel = rs.getString("tel");
                String jg = rs.getString("jg");
                String flag = rs.getString("flag");

                //将数据表的记录封装到对象
                StudentInfo stu = new StudentInfo();

                stu.setId(id);
                stu.setName(name);
                stu.setSex(sex);
                stu.setAge(age);
                stu.setYs(ys);
                stu.setClassName(aClass);
                stu.setHireDate(hiredate);
                stu.setTel(tel);
                stu.setJg(jg);
                stu.setFlag(flag);

                list.add(stu);//将对象放入到集合中

            }

            return list;


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeConnecion(rs,pdst,conn);
        }
        return null;
    }
}
