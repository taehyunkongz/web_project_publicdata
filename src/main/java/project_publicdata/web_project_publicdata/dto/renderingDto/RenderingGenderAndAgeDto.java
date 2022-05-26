package project_publicdata.web_project_publicdata.dto.renderingDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.FemaleDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.GenderDto.MaleDto;
import project_publicdata.web_project_publicdata.dto.genderAndAgeDto.ageDto.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RenderingGenderAndAgeDto {

    private EightySDto eightySDto;

    private FiftySDto fiftySDto;

    private FortySDto fortySDto;

    private KidsDto kidsDto;

    private SeventySDto seventySDto;

    private SixtySDto sixtySDto;

    private TeenagersDto teenagersDto;

    private ThirtySDto thirtySDto;

    private TwentySDto twentySDto;

    private FemaleDto femaleDto;

    private MaleDto maleDto;

}
