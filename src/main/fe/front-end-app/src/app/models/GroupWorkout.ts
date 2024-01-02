import { FitnessUser } from "./FitnessUser";
import { GroupWorkoutId } from "./GroupWorkoutId";

export interface GroupWorkout {
    groupWorkoutId: GroupWorkoutId,
    name: string,
    hallNumber: number,
    description: string,
    users: FitnessUser[]
}