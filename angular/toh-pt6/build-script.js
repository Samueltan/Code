const fs = require('fs-extra');
const concat = require('concat');

(async function build() {

    const files = [
        './dist/polyfills.js',
        './dist/main.js',
        './dist/runtime.js'

    ]

    await fs.ensureDir('elements');
    await concat(files, 'elements/myelement.js')

})() 