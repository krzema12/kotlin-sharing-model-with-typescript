import { com } from './sharedModel/kotlin-sharing-model-with-typescript-api';
import Cat = com.github.krzema12.api.Cat;

const cat = new Cat('Felix', 12);
console.log(cat.age)
