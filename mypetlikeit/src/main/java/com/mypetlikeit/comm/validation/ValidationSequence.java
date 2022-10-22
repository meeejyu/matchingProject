package com.mypetlikeit.comm.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.mypetlikeit.comm.validation.ValidationGroups.NotEmptyGroup;
import com.mypetlikeit.comm.validation.ValidationGroups.PatternCheckGroup;

@GroupSequence({Default.class, NotEmptyGroup.class, PatternCheckGroup.class})
public interface ValidationSequence {
    
}
