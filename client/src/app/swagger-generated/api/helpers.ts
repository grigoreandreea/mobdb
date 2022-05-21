// export const transformUnderscoreKeysToCamelCase = (obj): any => {
//   return Object.keys(obj).reduce((acc, key) => {
//     let newKey = '', lastIdx = 0;
//     if (key.indexOf('_') === -1) {
//       newKey = key;
//     } else {
//       for (let idx = 0; idx < key.length; idx++) {
//         if (key[idx] === '_') {
//           const substr = key.substring(lastIdx, idx);
//           newKey += lastIdx === 0 ? substr : capitalizeFirstLetter(substr);
//           lastIdx = idx + 1;
//         }
//         if (idx === key.length - 1) {
//           newKey += capitalizeFirstLetter(key.substring(lastIdx, idx + 1));
//         }
//       }
//     }
//     acc[newKey] = obj[key];
//     return acc;
//   }, {});
// }

// export const transformCamelCaseKeysToUnderscore = (obj): any => {
//   return Object.keys(obj).reduce((acc, key) => {
//     let newKey = '', lastIdx = 0;
//     if (stringDoesNotContainUpperCase(key)) {
//       newKey = key;
//     } else {
//       for (let idx = 0; idx < key.length; idx++) {
//         if (key[idx].toUpperCase() === key[idx]) {
//           const substr = key.substring(lastIdx, idx);
//           newKey += lastIdx === 0 ? decapitalizeFirstLetter(substr) : `_${decapitalizeFirstLetter(substr)}`;
//           lastIdx = idx;
//         }
//         if (idx === key.length - 1) {
//           const substr = key.substring(lastIdx, idx + 1);
//           newKey += `_${decapitalizeFirstLetter(substr)}`;
//         }
//       }
//     }
//     acc[newKey] = obj[key];
//     return acc;
//   }, {});
// }

function capitalizeFirstLetter(string) {
  return string.charAt(0).toUpperCase() + string.slice(1);
}

function decapitalizeFirstLetter(string) {
  return string.charAt(0).toLowerCase() + string.slice(1);
}

function stringDoesNotContainUpperCase(string) {
  let count = 0;
  for (let idx = 0; idx < string.length; idx++) {
    if (string[idx] === string[idx].toUpperCase()) {
      count ++;
    }
  }
  return count === 0;
}
