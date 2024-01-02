import { GroupWorkout } from './GroupWorkout';
import { IndividualWorkout } from './IndividualWorkout';

export interface FitnessUser{
    email: string,
    username: string,
    password: string,
    individualWorkouts: IndividualWorkout[],
    groupWorkouts: GroupWorkout[]
}