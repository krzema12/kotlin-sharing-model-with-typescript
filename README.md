This is a work-in-progress of an example of generating TypeScript definitions out of Kotlin data classes.

Steps to generate the typings:

1. Build the API project:
   ```
   ./gradlew :api:build
   ```
1. See the file `api/build/compileSync/main/productionExecutable/kotlin/kotlin-sharing-model-with-typescript-api.d.ts`.
   At the time of writing this, I got this:
   ```typescript
   type Nullable<T> = T | null | undefined
   export namespace com.github.krzema12.api {
       class Cat {
           constructor(name: string, age: number);
           readonly name: string;
           readonly age: number;
           readonly Companion: {
               serializer(): kotlinx.serialization.KSerializer<com.github.krzema12.api.Cat>;
           };
           readonly $serializer: {
               readonly descriptor: kotlinx.serialization.descriptors.SerialDescriptor;
           } & kotlinx.serialization.internal.GeneratedSerializer<com.github.krzema12.api.Cat>;
           component1(): string;
           component2(): number;
           copy(name: string, age: number): com.github.krzema12.api.Cat;
           toString(): string;
           hashCode(): number;
           equals(other: Nullable<any>): boolean;
           static Cat_init_$Create$(seen1: number, name: Nullable<string>, age: number, serializationConstructorMarker: Nullable<kotlinx.serialization.internal.SerializationConstructorMarker>): com.github.krzema12.api.Cat;
       }
   }
   export as namespace kotlin_sharing_model_with_typescript_api;
   ```

Steps to reproduce the TypeScript issue using already generated typings from Kotlin:

1. Install dependencies and build the frontend project:
   ```
   > yarn install && yarn build
   ```
1. The problem is getting this issue:
   ```
   Failed to compile.

   ./src/index.tsx
   SyntaxError: /home/piotr/repos/kotlin-sharing-model-with-typescript/src/index.tsx: `import =` is not supported by @babel/plugin-transform-typescript
   Please consider using `import <moduleName> from '<moduleName>';` alongside Typescript's --allowSyntheticDefaultImports option.
   1 | import { com } from './sharedModel/kotlin-sharing-model-with-typescript-api';
   > 2 | import Cat = com.github.krzema12.api.Cat;
   | ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   3 |
   4 | const cat = new Cat('Felix', 12);
   5 | console.log(cat.age)

   ```
