import { GroupWorkout } from './GroupWorkout';
import { IndividualWorkout } from './IndividualWorkout';

export interface Coach {
    email: string,
    username: string,
    phoneNUmber: string,
    education: string,
    professionalExperience: string,
    individualWorkouts: IndividualWorkout[],
    groupWorkouts: GroupWorkout[]
}