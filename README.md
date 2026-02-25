# capacitor-advanced-haptics

Advanced haptic engine for Android

## Install

```bash
npm install capacitor-advanced-haptics
npx cap sync
```

## Examples
```
import { AdvancedHaptics } from 'capacitor-advanced-haptics'

await AdvancedHaptics.vibrate({
  duration: 300,
  amplitude: 255
})
```


```
let inv : any;
let i = 0;

inv = setInterval(async () => {
    await AdvancedHaptics.predefined({type: 'tick'})
    i++
    if (i >= 10) {
        clearInterval(inv );
    }
}, 200);
```

## API

<docgen-index>

* [`vibrate(...)`](#vibrate)
* [`vibratePattern(...)`](#vibratepattern)
* [`predefined(...)`](#predefined)
* [`cancel()`](#cancel)
* [`hasAmplitudeControl()`](#hasamplitudecontrol)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### vibrate(...)

```typescript
vibrate(options: { duration?: number; amplitude?: number; }) => Promise<void>
```

| Param         | Type                                                    |
| ------------- | ------------------------------------------------------- |
| **`options`** | <code>{ duration?: number; amplitude?: number; }</code> |

--------------------


### vibratePattern(...)

```typescript
vibratePattern(options: { pattern: number[]; repeat?: number; }) => Promise<void>
```

| Param         | Type                                                 |
| ------------- | ---------------------------------------------------- |
| **`options`** | <code>{ pattern: number[]; repeat?: number; }</code> |

--------------------


### predefined(...)

```typescript
predefined(options: { type: 'click' | 'tick' | 'heavy'; }) => Promise<void>
```

| Param         | Type                                                 |
| ------------- | ---------------------------------------------------- |
| **`options`** | <code>{ type: 'click' \| 'tick' \| 'heavy'; }</code> |

--------------------


### cancel()

```typescript
cancel() => Promise<void>
```

--------------------


### hasAmplitudeControl()

```typescript
hasAmplitudeControl() => Promise<{ value: boolean; }>
```

**Returns:** <code>Promise&lt;{ value: boolean; }&gt;</code>

--------------------

</docgen-api>
