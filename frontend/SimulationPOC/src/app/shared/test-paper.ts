import { Subject } from './subject';
import { Question } from './question';

export class TestPaper {
    public testId:number;
    public testName:string;
    public subject:Subject;
    public questions:Question[];
}
