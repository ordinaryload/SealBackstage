package load.mapper;

import java.util.List;
import load.bean.Goods;
import load.bean.GoodsExample;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    long countByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    int deleteByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("version") String version);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    int insert(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    int insertSelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    List<Goods> selectByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    Goods selectByPrimaryKey(@Param("id") Integer id, @Param("version") String version);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Tue May 14 23:30:01 CST 2019
     */
    int updateByPrimaryKey(Goods record);
}