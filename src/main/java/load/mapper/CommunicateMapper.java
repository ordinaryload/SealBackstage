package load.mapper;

import java.util.List;
import load.bean.Communicate;
import load.bean.CommunicateExample;
import org.apache.ibatis.annotations.Param;

public interface CommunicateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    long countByExample(CommunicateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    int deleteByExample(CommunicateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    int insert(Communicate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    int insertSelective(Communicate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    List<Communicate> selectByExample(CommunicateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    Communicate selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    int updateByExampleSelective(@Param("record") Communicate record, @Param("example") CommunicateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    int updateByExample(@Param("record") Communicate record, @Param("example") CommunicateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    int updateByPrimaryKeySelective(Communicate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table communicate
     *
     * @mbg.generated Tue May 14 22:10:49 CST 2019
     */
    int updateByPrimaryKey(Communicate record);
}