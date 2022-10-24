package com.mypetlikeit.comm.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.mypetlikeit.comm.validation.ValidationGroups.NotBlankGroup;
import com.mypetlikeit.comm.validation.ValidationGroups.PatternCheckGroup;

@GroupSequence({Default.class, NotBlankGroup.class, PatternCheckGroup.class})
public interface ValidationSequence {
    
}
