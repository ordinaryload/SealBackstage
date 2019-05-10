package load.mapper;

import java.util.List;
import load.bean.Settings;
import load.bean.SettingsExample;
import org.apache.ibatis.annotations.Param;

public interface SettingsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    long countByExample(SettingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    int deleteByExample(SettingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    int insert(Settings record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    int insertSelective(Settings record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    List<Settings> selectByExample(SettingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    Settings selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    int updateByExampleSelective(@Param("record") Settings record, @Param("example") SettingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    int updateByExample(@Param("record") Settings record, @Param("example") SettingsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    int updateByPrimaryKeySelective(Settings record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table settings
     *
     * @mbg.generated Fri May 10 17:34:26 CST 2019
     */
    int updateByPrimaryKey(Settings record);
}